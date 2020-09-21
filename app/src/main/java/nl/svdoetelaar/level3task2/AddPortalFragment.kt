package nl.svdoetelaar.level3task2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.add_portal_fragment.*

const val PORTAL_TITLE = "portal_title"
const val PORTAL_URL = "portal_url"

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddPortalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.add_portal_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAddPortal.setOnClickListener {
            onAddPortal()
        }
    }

    private fun onAddPortal() {
        val portalTitle = etTitle.text.toString()
        val portalUrl = etUrl.text.toString()

        if (portalTitle.isNotBlank() and portalUrl.isNotBlank()) {
            setFragmentResult(PORTAL_TITLE, bundleOf(Pair(PORTAL_TITLE, portalTitle)))
            setFragmentResult(PORTAL_URL, bundleOf(Pair(PORTAL_URL, portalUrl)))

            findNavController().popBackStack()
        } else {
            Toast.makeText(
                activity,
                R.string.invalid_portal,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}