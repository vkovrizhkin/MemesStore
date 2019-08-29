package com.kovrizhkin.memesstore.view.screens.main.fragments


import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.kovrizhkin.memesstore.R
import com.kovrizhkin.memesstore.model.memes.MemInfo
import com.kovrizhkin.memesstore.presenters.MemListPresenter
import com.kovrizhkin.memesstore.presenters.PresenterContract
import com.kovrizhkin.memesstore.utils.MemesDiffUtil
import com.kovrizhkin.memesstore.view.ViewContract
import com.kovrizhkin.memesstore.view.adapters.MemRecViewAdapter
import com.kovrizhkin.memesstore.view.screens.DetailMemActivity
import kotlinx.android.synthetic.main.fragment_mem_list.view.*


class MemListFragment : Fragment(), ViewContract.IMemListView {

    private lateinit var presenter: PresenterContract.IMemListPresenter

    private lateinit var mAdapter: MemRecViewAdapter

    private var memesList = mutableListOf<MemInfo>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        retainInstance = true
        val view = inflater.inflate(R.layout.fragment_mem_list, container, false)

        initRecView(view.memRecView)
        view.swipeToRefresh.setOnRefreshListener { getFreshMemes() }
        view.swipeToRefresh.setProgressBackgroundColorSchemeColor(resources.getColor(R.color.colorAccent))
        presenter = MemListPresenter(this)
        getFreshMemes()
        return view
    }


    private val onClickItemCallback = { mem: MemInfo ->
        val intent = Intent(activity, DetailMemActivity::class.java)
        intent.putExtra(DetailMemActivity.MEM_EXTRA_KEY, mem)
        activity!!.startActivity(intent)
    }

    private fun initRecView(recView: RecyclerView) {

        mAdapter = MemRecViewAdapter(memesList, onClickItemCallback)

        recView.apply {
            adapter = mAdapter

            if (layoutManager == null) layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

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

    private fun getFreshMemes() {
        startLoading()
        presenter.updateMemesList()
    }

    private fun startLoading() {
        if (memesList.isEmpty()) {
            if (activity is ViewContract.ITabNavigatorContainer) {
                (activity as ViewContract.ITabNavigatorContainer).showLoading()
            }
        }
    }


    private fun stopLoading() {
        if (memesList.isEmpty()) {
            if (activity is ViewContract.ITabNavigatorContainer) {
                (activity as ViewContract.ITabNavigatorContainer).hideLoading()
            }
        }
        view!!.swipeToRefresh.isRefreshing = false
    }

    override fun showMemes(memes: List<MemInfo>) {
        stopLoading()
        memesList = memes as MutableList<MemInfo>
        val diffCallback = MemesDiffUtil(mAdapter.memesList, memes)
        val memDiffResult = DiffUtil.calculateDiff(diffCallback)
        mAdapter.memesList = memes
        memDiffResult.dispatchUpdatesTo(mAdapter)
    }

    override fun showError(t: Throwable) {
        stopLoading()
    }


}
