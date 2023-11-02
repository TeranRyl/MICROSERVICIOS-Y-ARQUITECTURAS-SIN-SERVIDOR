package edu.microservicios.cognito;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.*;

import java.util.LinkedHashMap;
import java.util.Map;

// Esta clase representa un cliente para interactuar con Amazon Cognito
public class CognitoClient {

    // Cliente de Amazon Cognito
    private final AWSCognitoIdentityProvider client ;

    // Identificador del cliente de Cognito
    private final String clientId = "CLIENT_ID";

    // Identificador del grupo de usuarios en Cognito
    private final String userPool = "USER_POOL_ID";

    // Constructor que inicializa el cliente de Cognito
    public CognitoClient() {
        client = createCognitoClient();
    }

    // Método privado para crear el cliente de Amazon Cognito con las credenciales y configuraciones proporcionadas
    private AWSCognitoIdentityProvider createCognitoClient() {
        // Credenciales de acceso a Amazon Cognito
        AWSCredentials cred = new BasicAWSCredentials("ACCESS_KEY", "SECRET_ACCESS_KEY");

        // Proveedor de credenciales estáticas
        AWSCredentialsProvider credProvider = new AWSStaticCredentialsProvider(cred);

        // Construcción del cliente de Amazon Cognito
        return AWSCognitoIdentityProviderClientBuilder.standard()
                .withCredentials(credProvider)
                .withRegion(Regions.US_WEST_2)
                .build();
    }

    // Método para registrar un nuevo usuario en Cognito
    public SignUpResult signUp(String name, String email, String password) {
        SignUpRequest request = new SignUpRequest().withClientId(clientId ).withUsername(email).withPassword(password);
        SignUpResult result = client.signUp(request);
        return result;
    }

    // Método para confirmar el registro de un usuario en Cognito
    public ConfirmSignUpResult confirmSignUp(String email, String confirmationCode) {
        ConfirmSignUpRequest confirmSignUpRequest = new ConfirmSignUpRequest().withClientId(clientId).withUsername(email).withConfirmationCode(confirmationCode);
        return client.confirmSignUp(confirmSignUpRequest);
    }

    // Método para realizar el inicio de sesión de un usuario en Cognito
    public Map<String, String> login(String email, String password) {
        // Parámetros de autenticación
        Map<String, String> authParams = new LinkedHashMap<String, String>() {{
            put("USERNAME", email);
            put("PASSWORD", password);
        }};

        // Solicitud de inicio de sesión administrativo
        AdminInitiateAuthRequest authRequest = new AdminInitiateAuthRequest()
                .withAuthFlow(AuthFlowType.ADMIN_NO_SRP_AUTH)
                .withUserPoolId(userPool)
                .withClientId(clientId)
                .withAuthParameters(authParams);

        // Resultado de la autenticación
        AdminInitiateAuthResult authResult = client.adminInitiateAuth(authRequest);
        AuthenticationResultType resultType = authResult.getAuthenticationResult();

        // Mapa de resultados de autenticación
        return new LinkedHashMap<String, String>() {{
            put("idToken", resultType.getIdToken());
            put("accessToken", resultType.getAccessToken());
            put("refreshToken", resultType.getRefreshToken());
            put("message", "Successfully login");
        }};
    }
}
