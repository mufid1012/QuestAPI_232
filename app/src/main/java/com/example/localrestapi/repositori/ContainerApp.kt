package com.example.localrestapi.repositori

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

interface ContainerApp {
    val repositoryDataSiswa: RepositoryDataSiswa
}

class DefaultContainerApp {
    val repositoryDataSiswa : RepositoryDataSiswa
}

