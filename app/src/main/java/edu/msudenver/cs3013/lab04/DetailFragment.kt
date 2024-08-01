import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.activity.viewModels
import com.google.android.gms.maps.model.LatLng
import edu.msudenver.cs3013.lab04.SharedViewModel
import edu.msudenver.cs3013.lab04.databinding.FragmentDetailBinding
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels

private const val TAG = "MapsFragment"

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    // shared viewmodel
    private val viewModel: SharedViewModel by activityViewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.location.observe(viewLifecycleOwner, Observer { item ->
            Log.d(TAG, "Location changed: $item")
            updateLocationText(item)
        })
    }

    private fun updateLocationText(location: LatLng) {
        binding.textViewLocation.text = location.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
