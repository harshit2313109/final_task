package com.example.notice_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [fragment_home_t.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_home_t : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var myrecyclerview: RecyclerView
    lateinit var myrecyclerview2:RecyclerView
    lateinit var  myshowupdata:ArrayList<Rv_Model>
    lateinit var myshowupdata2:ArrayList<Rv_Model>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val avatarImageView = view.findViewById<ImageView>(R.id.drawer)
        myrecyclerview=view.findViewById(R.id.recyclerview)


        myshowupdata = ArrayList()
        myshowupdata.add(Rv_Model("Scholarship Notice", "This is to inform you.... "))
        myshowupdata.add(Rv_Model("Tablet Notice", "Tablets are to be given from...."))
        myshowupdata.add(Rv_Model("Branch change", "the result for the branch change...."))
        myshowupdata.add(Rv_Model("Result announcement", "the result for the branch change...."))
        myshowupdata.add(Rv_Model("Sports Event", "the result for the branch change...."))

        myrecyclerview.adapter = rv_adapter(myshowupdata,requireContext())
        myrecyclerview.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)



        myrecyclerview2=view.findViewById(R.id.recyclerview2)
        myshowupdata2 = ArrayList()
        myshowupdata2.add(Rv_Model("Scholarship Notice", "This is to inform you.... "))
        myshowupdata2.add(Rv_Model("Tablet Notice", "Tablets are to be given from...."))
        myshowupdata2.add(Rv_Model("Branch change", "the result for the branch change...."))
        myshowupdata2.add(Rv_Model("Result announcement", "the result for the branch change...."))
        myshowupdata2.add(Rv_Model("Sports Event", "the result for the branch change...."))


        myrecyclerview2.adapter = rv_adapter(myshowupdata2,requireContext())
        myrecyclerview2.layoutManager = LinearLayoutManager(requireContext())

        // Define a list of available avatar drawable resources
        val avatarList = listOf(
            R.drawable.avatar_1,
            R.drawable.avatar2,
            R.drawable.avatar_3,
            R.drawable.avatar_4,
            R.drawable.avatar_5,
            R.drawable.avatar_6,
            R.drawable.avatar_7,
            R.drawable.avatar_8,
            R.drawable.avatar_9,
            R.drawable.avatar_10
        )
        // Pick a random avatar
        val randomAvatar = avatarList.random()
        // Set the randomly selected avatar to the ImageView
        avatarImageView.setImageResource(randomAvatar)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_t, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment_home_t().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}