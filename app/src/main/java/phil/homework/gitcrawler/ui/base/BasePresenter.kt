package phil.homework.gitcrawler.ui.base

interface BasePresenter<V: BaseView> {

    fun attachView(view: V)

    fun detachView()

}