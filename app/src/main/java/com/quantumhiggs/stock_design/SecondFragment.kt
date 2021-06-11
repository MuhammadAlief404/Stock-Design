package com.quantumhiggs.stock_design

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement
import com.quantumhiggs.stock_design.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val stockChart = view.findViewById<AAChartView>(R.id.reporting_chart)

        val aaChartModel : AAChartModel = AAChartModel()
            .chartType(AAChartType.Spline)
            .backgroundColor("#ffffff")
            .dataLabelsEnabled(false)
            .categories(arrayOf("Jul 19", "Okt 19", "Jan 20", "Apr 20", "Jul 20"))
            .series(arrayOf(
                AASeriesElement()
                    .name("2.5%")
                    .data(arrayOf(0, 1, 3, 4, 5))
                    .color("#E2EBDD"),
                AASeriesElement()
                    .name("8.53%")
                    .data(arrayOf(0, 2, 7, 12, 25))
                    .color("#E0DBEA"),
                AASeriesElement()
                    .name("10%")
                    .data(arrayOf(0, 3, 10, 20, 40))
                    .color("#E0E7EE")
            )
            )

        stockChart.aa_drawChartWithChartModel(aaChartModel)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}