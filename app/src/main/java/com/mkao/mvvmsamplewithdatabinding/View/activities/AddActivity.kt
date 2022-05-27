package com.mkao.mvvmsamplewithdatabinding.View.activities

import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.mkao.mvvmsamplewithdatabinding.R
import com.mkao.mvvmsamplewithdatabinding.ViewModel.AddViewModel
import com.mkao.mvvmsamplewithdatabinding.data.model.Movie

class AddActivity : BaseActivity() {
    private lateinit var Toolbar by lazy { toolbar_toolbar_view as Toolbar }

    private lateinit var viewModel: AddViewModel

    override fun getToolbarInstance(): Toolbar? = toolbar

    fun searchMovieClicked(view: View){
        if (titleEditText.text.toString().isNotBlank()){
            startActivity(intentFor<SearchActivity>("title" to titleEditText.text.toString()))
        }else{
            showMessage(getString(R.string.enter_tiltle))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        viewModel = ViewModelProvider.of(this).get(AddViewModel::class.java)
    }
    private fun showMessage(msg:String){
        addLayout.snack(msg),Snackbar.LENGHT_LONG){
            action(getString(R.string.ok)){

            }
        }
    }
    fun addMovieClicked(view: View){
        if (titleEditText.text.toString().isNotBlank()){
            viewModel.saveMovie(Movie(title = titleEditText.text.toString(), releaseDate = yearEditText.text.toString()))

            finish()
        }else{
            showMessage(getString(R.string.enter_title))
        }
    }
}