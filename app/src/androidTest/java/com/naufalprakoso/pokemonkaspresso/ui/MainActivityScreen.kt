package com.naufalprakoso.pokemonkaspresso.ui

import android.view.View
import com.agoda.kakao.common.views.KView
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.text.KTextView
import com.naufalprakoso.pokemonkaspresso.R
import org.hamcrest.Matcher

object MainActivityScreen : KScreen<MainActivityScreen>() {

    override val layoutId: Int? = R.layout.activity_main
    override val viewClass: Class<*>? = MainActivity::class.java

    val recycler = KRecyclerView({
        withId(R.id.rvData)
    }, itemTypeBuilder = {
        itemType(::Item)
    })

    val textView = KTextView {
        withId(R.id.tvSample)
    }

    class Item(parent: Matcher<View>) : KRecyclerItem<Item>(parent) {
        val pokemonName = KTextView(parent) { withId(R.id.tvName) }
        val self = KView {
            withMatcher(parent)
        }
    }

}