package com.elkite.warborn.data.network

import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.js.Js

actual fun getPlatformEngine(): HttpClientEngineFactory<*> = Js