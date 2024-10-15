package com.devrachit.playground.presentation.screens.model3d

import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.FragmentActivity
import com.google.android.filament.Camera
import com.google.android.filament.Scene
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment

@Composable
fun Model3dScreen() {

}

//@Composable
//fun ModelViewerScreen() {
//    AndroidView(
//        factory = { context ->
//            FrameLayout(context).apply {
//                id = View.generateViewId()
//                layoutParams = FrameLayout.LayoutParams(
//                    FrameLayout.LayoutParams.MATCH_PARENT,
//                    FrameLayout.LayoutParams.MATCH_PARENT
//                )
//            }
//        },
//        update = { view ->
//            val arFragment = ArFragment().apply {
//                setOnSessionConfigurationListener { session, _ ->
//                    // Configure the AR session here if needed
//                }
//            }
//
//            // Adding the AR fragment to the activity
//            val fragmentTransaction =
//                (view.context as FragmentActivity).supportFragmentManager.beginTransaction()
//            fragmentTransaction.add(view.id, arFragment)
//            fragmentTransaction.commit()
//
//            // Load the 3D model into the scene
//            arFragment.arSceneView.scene.addOnUpdateListener {
//                val modelUri = Uri.parse("push_up.glb") // Specify your 3D model file
//                ModelRenderable.builder()
//                    .setSource(view.context, modelUri)
//                    .build()
//                    .thenAccept { renderable ->
//                        val anchorNode = AnchorNode().apply {
//                            setRenderable(renderable)
//                        }
//                        arFragment.arSceneView.scene.addChild(anchorNode)
//                    }
//                    .exceptionally {
//                        Log.e("ModelViewer", "Error loading 3D model", it)
//                        null
//                    }
//            }
//        }
//    )
//}
