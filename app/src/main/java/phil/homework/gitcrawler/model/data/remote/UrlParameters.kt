package phil.homework.gitcrawler.model.data.remote

// URL Builder
const val REPOSITORY_BASE_URL = "https://api.github.com"
const val REPOSITORY_SEARCH_PATH = "/search/repositories"

// Query Builder
const val REPOSITORY_QUERY_IDENTIFIER = "q"
const val REPOSITORY_QUALIFIER_USER_NAME = "user:"
const val REPOSITORY_QUALIFIER_REPO_NAME = "+in:name"

const val REPOSITORY_SORT_IDENTIFIER = "sort"
const val REPOSITORY_SORT_BEST_MATCH = "best_match"
const val REPOSITORY_SORT_STARS = "stars"
const val REPOSITORY_SORT_LATEST_COMMIT = "updated"