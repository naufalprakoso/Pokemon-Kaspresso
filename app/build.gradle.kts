plugins {
	id("com.android.application")
	id("kotlin-android")
	id("kotlin-android-extensions")
	id("kotlin-kapt")
	id("dagger.hilt.android.plugin")
}

android {
	compileSdkVersion(29)
	buildToolsVersion("29.0.3")

	defaultConfig {
		applicationId = AppConfiguration.applicationId
		minSdkVersion(AppConfiguration.minSdkVersion)
		targetSdkVersion(AppConfiguration.targetSdkVersion)
		versionCode = AppConfiguration.versionCode
		versionName = AppConfiguration.versionName
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}

	buildTypes {
		getByName("release") {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
		getByName("debug") {
			applicationIdSuffix = ".debug"
			isDebuggable = true
		}
	}

	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}

	kotlinOptions {
		jvmTarget = "1.8"
	}

	buildFeatures {
		viewBinding = true
	}

}

dependencies {
	implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

	// Android Support
	implementation(Dependencies.appCompat)
	implementation(Dependencies.materialDesign)
	implementation(Dependencies.constraintLayout)
	implementation(Dependencies.annotation)
	implementation(Dependencies.legacySupport)

	// Architecture Component
	implementation(Dependencies.appCompat)
	implementation(Dependencies.lifeCycleExtension)
	kapt(Dependencies.lifeCycleCommonJava)

	// Testing
	testImplementation(Testing.jUnit)
	androidTestImplementation(Testing.extJUnit)
	androidTestImplementation(Testing.kaspresso)

	// Retrofit2
	implementation(Retrofit.retrofit)
	implementation(Retrofit.converterGson)

	// Coroutines
	implementation(Coroutines.core)
	implementation(Coroutines.android)

	// Room
	implementation(Room.runtime)
	implementation(Room.ktx)
	kapt(Room.compiler)

	// Hilt
	implementation(Hilt.hilt)
	implementation(Hilt.viewModel)
	kapt(Hilt.compiler)
	kapt(Hilt.viewModelCompiler)

	// Gson
	implementation(Dependencies.gson)

	// Ktx
	implementation(Dependencies.fragmentKtx)
	implementation(Dependencies.lifeCycleLiveData)
}