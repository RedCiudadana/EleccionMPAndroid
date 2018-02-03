package eleccionmp.redciudadana.org.eleccionmp.views.news

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.twitter.sdk.android.tweetui.SearchTimeline
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter
import eleccionmp.redciudadana.org.eleccionmp.MainActivity
import eleccionmp.redciudadana.org.eleccionmp.R
import kotlinx.android.synthetic.main.fragment_news.*

/**
 * Created by javier on 2/2/18.
 */

class NewsFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_news, container, false)
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).setTitle(R.string.news_title)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val timeline = SearchTimeline.Builder()
                .query("EleccionMP")
                .query("Eleccion MP")
                .query("Fiscal general MP")
                .build()
        val adapter = TweetTimelineListAdapter.Builder(context)
                .setTimeline(timeline)
                .build()
        news_list.adapter = adapter
    }
}