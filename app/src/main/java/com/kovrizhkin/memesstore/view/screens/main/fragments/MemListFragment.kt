package com.kovrizhkin.memesstore.view.screens.main.fragments


import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import com.kovrizhkin.memesstore.R
import com.kovrizhkin.memesstore.model.memes.MemInfo
import com.kovrizhkin.memesstore.presenters.MemListPresenter
import com.kovrizhkin.memesstore.presenters.PresenterContract
import com.kovrizhkin.memesstore.view.ViewContract
import com.kovrizhkin.memesstore.view.adapters.MemRecViewAdapter
import kotlinx.android.synthetic.main.fragment_mem_list.view.*


class MemListFragment : Fragment(), ViewContract.IMemListView {

    lateinit var presenter: PresenterContract.IMemListPresenter

    private lateinit var mAdapter: MemRecViewAdapter

    var memesList = listOf<MemInfo>()

    private val mLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        retainInstance = true
        val view = inflater.inflate(R.layout.fragment_mem_list, container, false)


        mAdapter = MemRecViewAdapter(memesList)

        view.apply {
            memRecView.apply {
                adapter = mAdapter
                layoutManager = mLayoutManager
                addItemDecoration(object : RecyclerView.ItemDecoration() {
                    override fun getItemOffsets(
                        outRect: Rect,
                        view: View,
                        parent: RecyclerView,
                        state: RecyclerView.State
                    ) {
                        super.getItemOffsets(outRect, view, parent, state)
                        val margin = resources.getDimension(R.dimen.margin_semi).toInt()
                        outRect.bottom = margin
                        outRect.top = margin
                        outRect.left = margin
                        outRect.right = margin
                    }
                })

            }
        }

        presenter = MemListPresenter(this)
        presenter.updateMemesList()
        return view
    }

    private fun getFreshMemes() {
        startLoading()
        presenter.updateMemesList()
    }

    private fun startLoading() {

    }

    private fun stopLoading() {

    }

    override fun showMemes(memes: List<MemInfo>) {
        /*memesList = memes
        mAdapter.notifyDataSetChanged()*/
        mAdapter = MemRecViewAdapter(memes)
        view!!.memRecView.adapter = mAdapter
    }

    override fun showError(t: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
