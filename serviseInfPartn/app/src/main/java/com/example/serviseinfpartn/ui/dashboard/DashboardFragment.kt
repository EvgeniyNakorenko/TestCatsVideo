package com.example.serviseinfpartn.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.serviseinfpartn.MainActivity
import com.example.serviseinfpartn.databinding.FragmentDashboardBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.DefaultPlayerUiController


class DashboardFragment : Fragment() {

    private val path = "https://www.youtube.com/watch?v=QKWAvLeayec&ab_channel=MARGO"
//    v=
    val videoId = "QKWAvLeayec"

    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val thirdPartyYouTubePlayerView = binding.thirdPartyPlayerView

        thirdPartyYouTubePlayerView.enableAutomaticInitialization = false

        val listener: YouTubePlayerListener = object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {

                val defaultPlayerUiController =
                    DefaultPlayerUiController(thirdPartyYouTubePlayerView, youTubePlayer)
                defaultPlayerUiController.showFullscreenButton(true)

                var mainActivity = activity as MainActivity

                defaultPlayerUiController.setFullScreenButtonClickListener {

                    if (thirdPartyYouTubePlayerView.isFullScreen()) {
                        thirdPartyYouTubePlayerView.exitFullScreen()
                        activity?.window?.decorView!!.systemUiVisibility =
                            View.SYSTEM_UI_FLAG_VISIBLE

                        mainActivity = activity as MainActivity
                        mainActivity.setBottomNavigationVisibility(View.VISIBLE)
                        mainActivity.supportActionBar?.show()

                    } else {
                        thirdPartyYouTubePlayerView.enterFullScreen()
                        activity?.window?.decorView!!.systemUiVisibility =
                            View.SYSTEM_UI_FLAG_FULLSCREEN

                        mainActivity = activity as MainActivity
                        mainActivity.setBottomNavigationVisibility(View.GONE)
                        mainActivity.supportActionBar?.hide()
                    }
                }

                thirdPartyYouTubePlayerView.setCustomPlayerUi(defaultPlayerUiController.rootView)

                youTubePlayer.cueVideo(videoId, 0f)
            }
        }

        val options: IFramePlayerOptions = IFramePlayerOptions.Builder().controls(0).build()
        thirdPartyYouTubePlayerView.initialize(listener, options)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
