package phil.homework.gitcrawler.model.data.remote

class QueryParameter {

    enum class SortingOption {
        BEST_MATCH,
        STARS,
        LATEST_COMMIT
    }

    enum class SearchingOption {
        BY_REPOSITORY_NAME,
        BY_USER_NAME
    }
}