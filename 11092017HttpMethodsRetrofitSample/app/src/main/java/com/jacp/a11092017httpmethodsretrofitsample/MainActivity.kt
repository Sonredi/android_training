package com.jacp.a11092017httpmethodsretrofitsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jacp.a11092017httpmethodsretrofitsample.entities.Comment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val commentService: RetrofitFactory.CommentService = RetrofitFactory.createService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        a_main_getAll.setOnClickListener { retrieveAllComments() }
        a_main_getOne.setOnClickListener { retrieveOneComment(1) }
        a_main_create.setOnClickListener { createComment() }
        a_main_update.setOnClickListener { updateComment(2) }
        a_main_delete.setOnClickListener { deleteComment(2) }

    }

    private fun deleteComment(commentId: Int) {
        commentService.deleteComment(commentId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer { println("TAG_ $it") })
    }

    private fun updateComment(commentId: Int) {
        val comment = Comment(commentId, "JACP modified", 1)
        commentService.updateComment(commentId, comment)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer { println("TAG_ $it") })
    }

    private fun createComment() {
        val comment = Comment(2, "JACP", 1)
        commentService.createComment(comment)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer { println("TAG_ $it") })
    }

//    private fun createComment() {
//        val comment = Comment(3, "This is the body!", 1)
//        commentService.createComment(comment)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(Consumer {
//                    println("TAG_ ${it.response()?.code()}")
//                    when (it.response()?.code()) {
//                        200 -> println("TAG_ Everything was right! ${it.response()?.body()}")
//                        500 -> println("TAG_ Item already created! Server error")
//                        else -> println("TAG_ Nah!")
//                    }
//                })
//    }

    private fun retrieveOneComment(commentId: Int) {
        commentService.retrieveOneComment(commentId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer { println("TAG_ $it") })
    }

    private fun retrieveAllComments() {
        commentService.retrieveAllComments()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer { it.forEach { println(it) } })
    }
}
