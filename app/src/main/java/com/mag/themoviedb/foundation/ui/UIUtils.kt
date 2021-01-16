package com.mag.themoviedb.foundation.ui

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

private fun FragmentManager.getLoadingFragment() =
    findFragmentByTag(LoadingFragment.TAG) as? LoadingFragment

fun FragmentManager.showLoadingFragment(
): LoadingFragment? =
    getLoadingFragment() ?: LoadingFragment.newInstance().apply {
        val action: FragmentTransaction.() -> Unit = {
            add(this@apply, LoadingFragment.TAG)
        }
        beginTransaction().apply(action).let {
            it.commitNow()
        }
    }
