package dev.proskor.myapplication.models

import dev.proskor.myapplication.api.ApiRepos
import kotlinx.serialization.Serializable

@Serializable
data class GitRepository(
val id: Int,
val node_id: String,
val name: String,
val full_name: String,
val private: Boolean,
val owner: GitUser,
val html_url: String,
val description: String,
val fork: Boolean,
val url: String,
val homepage: String,
val size: Int,
val stargazers_count: Int,
val watchers_count: Int,
val language: String,
val license: String,
val visibility: String,
val forks: Int,
val watchers: Int,
val default_branch: String
)
