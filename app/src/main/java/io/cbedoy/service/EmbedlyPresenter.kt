package io.cbedoy.service

class EmbedlyPresenter : EmbedlyContract.IEmbedlyPresenter{

    lateinit var interactor: EmbedlyContract.IEmbedlyInteractor

    override fun getMetadataFromURL(url: String, callback: EmbedlyContract.EmbedlyCallback) {
        interactor.requestFromURLWithCallback(url, callback)
    }
}