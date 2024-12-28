package com.onedrive.filemanager.data.auth

import com.azure.identity.DeviceCodeCredential
import com.azure.identity.DeviceCodeCredentialBuilder
import com.microsoft.graph.authentication.TokenCredentialAuthProvider
import com.microsoft.graph.requests.GraphServiceClient
import com.onedrive.filemanager.util.AuthConfig

class GraphAuthProvider {
    fun createGraphClient(): GraphServiceClient<*> {
        val credential = createCredential()
        val authProvider = TokenCredentialAuthProvider(AuthConfig.SCOPES.toList(), credential)
        return GraphServiceClient.builder()
            .authenticationProvider(authProvider)
            .buildClient()
    }

    private fun createCredential(): DeviceCodeCredential =
        DeviceCodeCredentialBuilder()
            .clientId(AuthConfig.CLIENT_ID)
            .tenantId(AuthConfig.TENANT_ID)
            .challengeConsumer { challenge ->
                println(challenge.getMessage())
            }
            .build()
}