package com.example.grandtask.domain.useCase

import com.example.grandtask.data.model.user.Users
import com.example.grandtask.data.util.Resource
import com.example.grandtask.domain.repository.UseRepository

class GetUserDataUseCase(private val useRepository: UseRepository) {

    suspend fun execute():Resource<Users>{
        return useRepository.getAllUsersRemote()
    }
}