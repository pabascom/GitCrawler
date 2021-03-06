package phil.homework.gitcrawler.model.entity.repository

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import phil.homework.gitcrawler.model.entity.repository.License
import phil.homework.gitcrawler.model.entity.repository.Owner
import phil.homework.gitcrawler.model.entity.repository.Permissions

class Repository {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("node_id")
    @Expose
    var nodeId: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("full_name")
    @Expose
    var fullName: String? = null
    @SerializedName("owner")
    @Expose
    var owner: Owner? = null
    @SerializedName("private")
    @Expose
    var private: Boolean? = null
    @SerializedName("html_url")
    @Expose
    var htmlUrl: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("fork")
    @Expose
    var fork: Boolean? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("archive_url")
    @Expose
    var archiveUrl: String? = null
    @SerializedName("assignees_url")
    @Expose
    var assigneesUrl: String? = null
    @SerializedName("blobs_url")
    @Expose
    var blobsUrl: String? = null
    @SerializedName("branches_url")
    @Expose
    var branchesUrl: String? = null
    @SerializedName("collaborators_url")
    @Expose
    var collaboratorsUrl: String? = null
    @SerializedName("comments_url")
    @Expose
    var commentsUrl: String? = null
    @SerializedName("commits_url")
    @Expose
    var commitsUrl: String? = null
    @SerializedName("compare_url")
    @Expose
    var compareUrl: String? = null
    @SerializedName("contents_url")
    @Expose
    var contentsUrl: String? = null
    @SerializedName("contributors_url")
    @Expose
    var contributorsUrl: String? = null
    @SerializedName("deployments_url")
    @Expose
    var deploymentsUrl: String? = null
    @SerializedName("downloads_url")
    @Expose
    var downloadsUrl: String? = null
    @SerializedName("events_url")
    @Expose
    var eventsUrl: String? = null
    @SerializedName("forks_url")
    @Expose
    var forksUrl: String? = null
    @SerializedName("git_commits_url")
    @Expose
    var gitCommitsUrl: String? = null
    @SerializedName("git_refs_url")
    @Expose
    var gitRefsUrl: String? = null
    @SerializedName("git_tags_url")
    @Expose
    var gitTagsUrl: String? = null
    @SerializedName("git_url")
    @Expose
    var gitUrl: String? = null
    @SerializedName("issue_comment_url")
    @Expose
    var issueCommentUrl: String? = null
    @SerializedName("issue_events_url")
    @Expose
    var issueEventsUrl: String? = null
    @SerializedName("issues_url")
    @Expose
    var issuesUrl: String? = null
    @SerializedName("keys_url")
    @Expose
    var keysUrl: String? = null
    @SerializedName("labels_url")
    @Expose
    var labelsUrl: String? = null
    @SerializedName("languages_url")
    @Expose
    var languagesUrl: String? = null
    @SerializedName("merges_url")
    @Expose
    var mergesUrl: String? = null
    @SerializedName("milestones_url")
    @Expose
    var milestonesUrl: String? = null
    @SerializedName("notifications_url")
    @Expose
    var notificationsUrl: String? = null
    @SerializedName("pulls_url")
    @Expose
    var pullsUrl: String? = null
    @SerializedName("releases_url")
    @Expose
    var releasesUrl: String? = null
    @SerializedName("ssh_url")
    @Expose
    var sshUrl: String? = null
    @SerializedName("stargazers_url")
    @Expose
    var stargazersUrl: String? = null
    @SerializedName("statuses_url")
    @Expose
    var statusesUrl: String? = null
    @SerializedName("subscribers_url")
    @Expose
    var subscribersUrl: String? = null
    @SerializedName("subscription_url")
    @Expose
    var subscriptionUrl: String? = null
    @SerializedName("tags_url")
    @Expose
    var tagsUrl: String? = null
    @SerializedName("teams_url")
    @Expose
    var teamsUrl: String? = null
    @SerializedName("trees_url")
    @Expose
    var treesUrl: String? = null
    @SerializedName("clone_url")
    @Expose
    var cloneUrl: String? = null
    @SerializedName("mirror_url")
    @Expose
    var mirrorUrl: String? = null
    @SerializedName("hooks_url")
    @Expose
    var hooksUrl: String? = null
    @SerializedName("svn_url")
    @Expose
    var svnUrl: String? = null
    @SerializedName("homepage")
    @Expose
    var homepage: String? = null
    @SerializedName("language")
    @Expose
    var language: Any? = null
    @SerializedName("forks_count")
    @Expose
    var forksCount: Int? = null
    @SerializedName("stargazers_count")
    @Expose
    var stargazersCount: Int? = null
    @SerializedName("watchers_count")
    @Expose
    var watchersCount: Int? = null
    @SerializedName("size")
    @Expose
    var size: Int? = null
    @SerializedName("default_branch")
    @Expose
    var defaultBranch: String? = null
    @SerializedName("open_issues_count")
    @Expose
    var openIssuesCount: Int? = null
    @SerializedName("topics")
    @Expose
    var topics: List<String>? = null
    @SerializedName("has_issues")
    @Expose
    var hasIssues: Boolean? = null
    @SerializedName("has_projects")
    @Expose
    var hasProjects: Boolean? = null
    @SerializedName("has_wiki")
    @Expose
    var hasWiki: Boolean? = null
    @SerializedName("has_pages")
    @Expose
    var hasPages: Boolean? = null
    @SerializedName("has_downloads")
    @Expose
    var hasDownloads: Boolean? = null
    @SerializedName("archived")
    @Expose
    var archived: Boolean? = null
    @SerializedName("disabled")
    @Expose
    var disabled: Boolean? = null
    @SerializedName("pushed_at")
    @Expose
    var pushedAt: String? = null
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null
    @SerializedName("permissions")
    @Expose
    var permissions: Permissions? = null
    @SerializedName("subscribers_count")
    @Expose
    var subscribersCount: Int? = null
    @SerializedName("network_count")
    @Expose
    var networkCount: Int? = null
    @SerializedName("license")
    @Expose
    var license: License? = null

}
