package com.example.zitrocrm.network.repository

import com.example.zitrocrm.network.models_dto.Filter.RegionesFilter.RegionesFilter
import com.example.zitrocrm.network.models_dto.Login.LoginDto
import com.example.zitrocrm.network.models_dto.Login.LoginrespDto
import com.example.zitrocrm.utils.Val_Constants
import retrofit2.Response
import retrofit2.http.*

interface AuthApiService {
    /**END POINTS**/
    /**LOGIN**/
    @Headers("Content-Type: application/json")
    @POST(Val_Constants.API_LOGIN)
    suspend fun getLogin(@Body loginDto: LoginDto) : LoginrespDto

    /**FILTER SALAS-CLIENTE-REGIONES**/
    @Headers()
    @GET(Val_Constants.API_CATALOGOS_REGIONES)
    suspend fun getRegiones (@Body loginDto: LoginDto ): List<RegionesFilter>


}