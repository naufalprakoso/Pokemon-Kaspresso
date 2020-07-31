package com.naufalprakoso.pokemonkaspresso.ui

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest : TestCase() {

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Test
    fun testRecyclerView1() {
        before {
            activityTestRule.launchActivity(null)
        }.after {

        }.run {

            step("1. Open Screen and Check RecyclerView is Not Empty") {
                MainActivityScreen {
                    recycler {
                        isVisible()
                        getSize() != 0
                    }
                }
            }

            step("2. Scroll to last position") {
                flakySafely(
                    timeoutMs = 15_000,
                    intervalMs = 3_000,
                    allowedExceptions = mutableSetOf(KotlinNullPointerException::class.java)
                ) {
                    MainActivityScreen {
                        recycler {
                            scrollToEnd()

                            lastChild<MainActivityScreen.Item> {
                                click()
                            }
                        }
                    }
                }
            }

        }
    }

    @Test
    fun testTextView1() {
        before {
            activityTestRule.launchActivity(null)
        }.after {

        }.run {

            step("Click TextView Sample and Replace the value") {
                MainActivityScreen {
                    textView {
                        isVisible()
                        hasEmptyText()
                    }
                }
            }

        }
    }

}