# Okta-Hosted Login Page Example

This example shows you how to implement Authorization Code flow using [Micronaut][Micronaut Framework] to login a user. The login is achieved through the [Authorization Code Flow][] where the user is redirected to the Okta-Hosted login page. After the user authenticates successfully, they are redirected back to the application, and a local cookie session is created.

## Prerequisites

Before running this sample, you will need the following:

* An Okta Developer Account, you can sign up for one at https://developer.okta.com/signup/.
* An Okta Application, configured for Web mode. This is done from the Okta Developer Console, and you can find instructions [here][OIDC Web Application Setup Instructions].
* In the above application, configure `http://localhost:8080/oauth/callback/okta` as `Login redirect URI` and
  configure `http://localhost:8080/logout` as `Logout redirect URI`. 
* The source code from this repository:
  
  ```bash
  git clone https://github.com/okta/samples-java-micronaut.git
  cd samples-java-micronaut
  ```

## Running This Example

You need to gather the following information from the Okta Developer Console:

- **Client ID** and **Client Secret** - These can be found on the "General" tab of the Web application that you created earlier in the Okta Developer Console.

- **Issuer** - This is the URL of the authorization server that will perform authentication.  All Developer Accounts have a "default" authorization server.  The issuer is a combination of your Org URL (found in the upper right of the console home page) and `/oauth2/default`. For example, `https://dev-1234.okta.com/oauth2/default`.

Set the below environment variables from terminal and start the application.

```bash
export OIDC_ISSUER_DOMAIN=https://{yourOktaDomain}  # e.g. https://dev-123456.okta.com
export OAUTH_CLIENT_ID={clientId}
export OAUTH_CLIENT_SECRET={clientSecret}
export OIDC_ISSUER_AUTHSERVERID=default # e.g. default or custom Authorization Server id

cd okta-hosted-login/
mvn mn:run
```

**Note:** If you are on Windows command line, use `SET` instead of `export` above.

Now, navigate to `http://localhost:8080` in your browser.

If you see a home page that prompts you to login, then things are working! Clicking the **Login** button will redirect you to the Okta hosted sign-in page.

You can login with the same account that you created when signing up for your Developer Org, or you can use a known username and password from your Okta Directory.

[Authorization Code Flow]: https://developer.okta.com/authentication-guide/implementing-authentication/auth-code
[OIDC Web Application Setup Instructions]: https://developer.okta.com/authentication-guide/implementing-authentication/auth-code#1-setting-up-your-application
[Micronaut Framework]: https://micronaut.io/