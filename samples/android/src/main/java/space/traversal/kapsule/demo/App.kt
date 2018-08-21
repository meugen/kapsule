/*
 * Copyright 2017 Traversal Space
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package space.traversal.kapsule.demo

import android.app.Application
import android.content.Context
import space.traversal.kapsule.demo.di.MainAndroidModule
import space.traversal.kapsule.demo.di.MainDataModule
import space.traversal.kapsule.demo.di.Module
import space.traversal.kapsule.transitive

/**
 * Custom application class.
 */
open class App : Application() {

    companion object {

        /**
         * Retrieves module from any context.
         */
        fun module(context: Context) = (context.applicationContext as App).module
    }

    private lateinit var module: Module

    override fun onCreate() {
        super.onCreate()
        module = Module(
                android = MainAndroidModule(this),
                data = MainDataModule()).transitive()
    }
}
