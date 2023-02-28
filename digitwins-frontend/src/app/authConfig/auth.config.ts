import {AuthConfig} from "angular-oauth2-oidc";


export const authconfig : AuthConfig = {
  issuer:"http://localhost:9009/realms/digitwins-realm",
  redirectUri: window.location.origin,
  clientId:"oauth2-digitwins",
  responseType: "code",
  strictDiscoveryDocumentValidation:true,
  scope:"openid profile email offline_access"
}
