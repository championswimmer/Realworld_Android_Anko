package com.codingblocks.conduit.anko.api.models



data class UserResponse(
    var user: User
)

data class ProfileResponse(
    var profile: Profile
)

data class ArticleResponse(
    var article: Article
)

data class ArticlesResponse(
    var articles: List<Article>,
    var articlesCount: Int
)


data class CommentsResponse(
    var comments: List<Comment>
)

data class CommentResponse(
    var comment: Comment
)


data class TagsResponse(
    var tags: List<String>
)

data class ErrorsResponse(
    var errors: Errors
)


data class User(
    var bio: String?,
    var email: String,
    var image: Any?,
    var token: String?,
    var username: String
)


data class Profile(
    var bio: String?,
    var following: Boolean,
    var image: String?,
    var username: String
)



data class Article(
    var author: Author,
    var body: String,
    var createdAt: String,
    var description: String?,
    var favorited: Boolean,
    var favoritesCount: Int,
    var slug: String,
    var tagList: List<String>,
    var title: String,
    var updatedAt: String
)

data class Author(
    var bio: String?,
    var following: Boolean,
    var image: String?,
    var username: String
)

data class Comment(
    var author: Author,
    var body: String,
    var createdAt: String,
    var id: Int,
    var updatedAt: String
)

data class Errors(
    var body: List<String>
)