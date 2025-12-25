package com.example.localrestapi.view.route

import com.example.localrestapi.R

object DestinasiDetail : DestinasiNavigasi {
    override val route = "detail_siswa"

    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"

    override val titleRes = R.string.detail_siswa
}
