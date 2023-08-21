package com.example.challengeapp.decoder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challengeapp.decoder.models.DecodedMessage
import com.google.gson.GsonBuilder

class DecoderViewModel: ViewModel() {

    private val _msgDecode = MutableLiveData<String>()
    val msgDecode get() = _msgDecode

    private val _msgPretty = MutableLiveData<String>()
    val msgPretty get() = _msgPretty

    fun onDecodeMessge(msgDecode: String) {
        splitString(msgDecode)
    }

    private fun splitString(text: String) {
        val data = arrayListOf<String>()
        text.apply {
            split(
                Regex("(?>=0)|(?>0)|(?=0)")
            ).forEach {
                if (it.isNotEmpty()) {
                    data.add(it.trim())
                }
            }

        }
        convertToJSON(data)
    }

    private fun convertToJSON(split: List<String>) {
        val decodedMessage = DecodedMessage()
        var othersString = ""
        split.forEachIndexed { index, s ->
            when(index.plus(1)) {
                1 -> decodedMessage.first_name = s
                2 -> decodedMessage.last_name = s
                3 -> decodedMessage.id = s
                else -> othersString += "$s - "
            }
        }
        decodedMessage.others = othersString
        val gsonPretty = GsonBuilder().setPrettyPrinting().create()
        val jsonTutPretty: String = gsonPretty.toJson(decodedMessage)
        msgPretty.value = jsonTutPretty
        println(jsonTutPretty)
    }

    fun setmsgDecoder(msg: String) {
        _msgDecode.value = msg
    }
}