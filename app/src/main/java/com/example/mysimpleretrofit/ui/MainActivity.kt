package com.example.mysimpleretrofit.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.mysimpleretrofit.databinding.ActivityMainBinding
import com.example.mysimpleretrofit.network.NetworkResponse
import com.example.mysimpleretrofit.network.RetrofitClient
import com.example.mysimpleretrofit.responseModels.MedicineDetailResponse
import com.example.mysimpleretrofit.responseModels.SecondApiResponse
import com.example.mysimpleretrofit.utils.Constants
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)

        binding.apply {
            api1.setOnClickListener(this@MainActivity)
            api2.setOnClickListener(this@MainActivity)
            api3.setOnClickListener(this@MainActivity)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.api1.id -> {
                println("api1")
                val fullUrl = Constants.BASE_URL_1 + "/medicine/get/by/id?"
                val call = RetrofitClient.getNetworkInterface()?.apiWithFirstUrl(
                    fullUrl,
                    Constants.CROCIN_ID
                )
                call?.enqueue(
                    object : Callback<MedicineDetailResponse> {
                        override fun onResponse(
                            call: Call<MedicineDetailResponse>,
                            response: Response<MedicineDetailResponse>
                        ) {
                            println("apiWithFirstUrl -> onResponse")
                            setOutput(response.body()?.result?.medicineName)
                        }

                        override fun onFailure(call: Call<MedicineDetailResponse>, t: Throwable) {
                            println("apiWithFirstUrl -> onFailure")
                            t.printStackTrace()
                            setOutput(t.message)
                        }

                    }
                )
            }
            binding.api2.id -> {
                println("api2")
//                val fullUrl = Constants.BASE_URL_2 + "/v1/aa0d426e-c897-4646-866f-9f666023f4a4"
                val call = RetrofitClient.getNetworkInterface()?.apiWithSecondUrl()
                call?.enqueue(
                    object : Callback<List<SecondApiResponse>> {
                        override fun onResponse(
                            call: Call<List<SecondApiResponse>>,
                            response: Response<List<SecondApiResponse>>
                        ) {
                            if (response.isSuccessful) {
                                val s = StringBuilder()
                                response.body()?.forEach {
                                    s.append(it.name + ",\n")
                                }
                                setOutput(s.toString())
                                println("apiWithSecondUrl -> onResponse")
                            }
                        }

                        override fun onFailure(call: Call<List<SecondApiResponse>>, t: Throwable) {
                            println("apiWithSecondUrl -> onFailure")
                            t.printStackTrace()
                            setOutput(t.message)
                        }

                    }
                )
            }
            binding.api3.id -> {
                val fullUrl = Constants.GITHUB_API + "/users/${binding.githubUsername.text}"
                CoroutineScope(Dispatchers.IO).launch {
                    when (val call =
                        RetrofitClient.getNetworkInterface()?.getGitHubUserData(fullUrl)) {
                        is NetworkResponse.Success -> {
                            setOutput(Gson().toJson(call.body))
                        }
                        is NetworkResponse.ApiError -> {
                            setOutput(call.body.message)
                        }
                        is NetworkResponse.NetworkError -> {
                            setOutput(call.error?.message)
                        }
                        is NetworkResponse.UnknownError -> {
                            setOutput(call.error?.message)
                        }
                        null -> {
                            setOutput("ERROR")
                        }
                    }
                }
            }
        }
    }

    private fun setOutput(output: String?) {
        runOnUiThread {
            binding.output.setText(output ?: "empty/null")
        }
    }
}