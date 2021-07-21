package com.example.foodapp.ui.fragments.favorites

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.adapters.FavoriteRecipesAdapter
import com.example.foodapp.databinding.FragmentFavoriteRecipesBinding
import com.example.foodapp.viewmodels.MainViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_favorite_recipes.view.*

@AndroidEntryPoint
class FavoriteRecipesFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private val mAdapter: FavoriteRecipesAdapter by lazy { FavoriteRecipesAdapter(requireActivity(), viewModel) }

    private var _binding: FragmentFavoriteRecipesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteRecipesBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.mainViewModel = viewModel
        binding.mAdapter = mAdapter

        setHasOptionsMenu(true)

        setupRecyclerView(binding.favoriteRecipesRecyclerView)

        return binding.root
    }

    private fun setupRecyclerView(recyclerView: RecyclerView){
        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        mAdapter.clearContextualActionMode()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.favorite_recipes_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.deleteAll_favorite_recipes_menu){
            viewModel.deleteAllFavoriteRecipes()
            showSnackBar("All recipes removed.")

        }
        return super.onOptionsItemSelected(item)
    }

    private fun showSnackBar(message: String){
        Snackbar.make(
            binding.root,
            message,
            Snackbar.LENGTH_SHORT
        ).setAction("Okay"){}
            .show()
    }

}