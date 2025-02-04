package com.airbnbclone.backend.user.presentation;

import com.airbnbclone.backend.user.application.UserService;
import com.airbnbclone.backend.user.application.dto.ReadUserDTO;
import jakarta.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthResource {

  private final UserService userService;

  private final ClientRegistration registration;

  public AuthResource(
    UserService userService,
    ClientRegistrationRepository registration
  ) {
    this.userService = userService;
    this.registration = registration.findByRegistrationId("okta");
  }

  @GetMapping("/get-authenticated-user")
  public ResponseEntity<ReadUserDTO> getAuthenticatedUser(
    @AuthenticationPrincipal OAuth2User user,
    @RequestParam boolean forceResync
  ) {
    System.out.println("user: " + user);
    if (user == null) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    } else {
      userService.syncWithIdp(user, forceResync);
      ReadUserDTO connectedUser = userService.getAuthenticatedUserFromSecurityContext();
      return new ResponseEntity<>(connectedUser, HttpStatus.OK);
    }
  }

  @PostMapping("/logout")
  public ResponseEntity<Map<String, String>> logout(
    HttpServletRequest request
  ) {
    String issuedUri = registration.getProviderDetails().getIssuerUri();
    String originUrl = request.getHeader(HttpHeaders.ORIGIN);
    Object[] params = { issuedUri, registration.getClientId(), originUrl };
    String logoutUrl = MessageFormat.format(
      "{0}v2/logout?client_id={1}&returnTo={2}",
      params
    );
    request.getSession().invalidate();
    return ResponseEntity.ok().body(Map.of("logoutUrl", logoutUrl));
  }
}
