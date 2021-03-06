package com.tata.bank.login

import java.lang.ref.WeakReference

enum class LoginConfigurator {
    INSTANCE;

    fun configure(activity: LoginActivity) {
        val router = LoginRouter()
        router.activity = WeakReference(activity)

        val presenter = LoginPresenter()
        presenter.output = WeakReference(activity)
        presenter.router = router

        val interactor = LoginInteractor()
        interactor.output = presenter
        interactor.context = activity.applicationContext

        activity.output = interactor
    }
}