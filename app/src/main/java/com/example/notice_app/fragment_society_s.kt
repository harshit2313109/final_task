package com.example.notice_app

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class fragment_society_s : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_society_s, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            val ccc: ImageView = view.findViewById(R.id.ccc)
            val si: ImageView = view.findViewById(R.id.si)
            val conatus: ImageView = view.findViewById(R.id.conatus)
            val pc: ImageView = view.findViewById(R.id.pc)
            val csi: ImageView = view.findViewById(R.id.csi)

            val horizon: ImageView = view.findViewById(R.id.horizon)
            val footprints: ImageView = view.findViewById(R.id.footprints)
            val taal: ImageView = view.findViewById(R.id.taal)
            val renessa: ImageView = view.findViewById(R.id.renessa)

            ccc.setOnClickListener {
                openWebsite("https://ccc-web.vercel.app/")
            }

            si.setOnClickListener {
                openWebsite("https://silive.in/")
            }

            conatus.setOnClickListener {
                openWebsite("https://teamconatus.com/")
            }

            pc.setOnClickListener {
                openWebsite("https://www.akgec.ac.in/programming-club/")
            }

            csi.setOnClickListener {
                openWebsite("https://www.csiakgec.in/")
            }

            // Cultural Society Links


            horizon.setOnClickListener {
                openWebsite("https://www.akgec.ac.in/life-akgec/societies/extra-curricular-societies/horizon/")
            }

            footprints.setOnClickListener {
                openWebsite("https://www.akgec.ac.in/life-akgec/societies/extra-curricular-societies/footprints/")
            }
            taal.setOnClickListener {
                openWebsite("https://www.akgec.ac.in/life-akgec/societies/extra-curricular-societies/taal/")
            }
            renessa.setOnClickListener {
                openWebsite("https://www.akgec.ac.in/life-akgec/societies/extra-curricular-societies/renaissance-2/")
            }
        }

    // Function to open a website
    private fun openWebsite(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }


    companion object {
        @JvmStatic
        fun newInstance() = fragment_society_s()
    }
}