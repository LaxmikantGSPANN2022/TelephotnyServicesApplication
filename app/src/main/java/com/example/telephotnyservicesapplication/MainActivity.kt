package com.example.telephotnyservicesapplication

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.TelephonyManager
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {

            val flagFeatureTelephony: Boolean = packageManager.hasSystemFeature("FEATURE_TELEPHONY")
            println("Device FeatureTelephony = $flagFeatureTelephony")


            var telephonyManager: TelephonyManager =
                getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

            val stringIMEINumber: String = telephonyManager.imei
            println("Device IMEINumber = $stringIMEINumber")

            val stringSubscriberId: String = telephonyManager.subscriberId
            println("Device SubscriberId = $stringSubscriberId")

            val stringSimSerialNumber: String = telephonyManager.simSerialNumber
            println("Device SimSerialNumber = $stringSimSerialNumber")

            var stringPhoneNetworkType: String? = ""
            val intPhoneNetworkType: Int = telephonyManager.dataNetworkType
            when (intPhoneNetworkType) {
                TelephonyManager.NETWORK_TYPE_LTE -> stringPhoneNetworkType = "No Type Found"
                TelephonyManager.NETWORK_TYPE_CDMA -> stringPhoneNetworkType = "SIP Type"
                TelephonyManager.NETWORK_TYPE_EDGE -> stringPhoneNetworkType = "CDMA Type"
                TelephonyManager.NETWORK_TYPE_GSM -> stringPhoneNetworkType = "GSM Type"
            }
            println("Device Phone NetworkType = $stringPhoneNetworkType")


            val stringNetworkCountryISO: String = telephonyManager.networkCountryIso
            println("Device NetworkCountryISO = $stringNetworkCountryISO")

            val stringSimCoutryISO: String = telephonyManager.simCountryIso
            println("Device SimCoutryISO = $stringSimCoutryISO")

            val stringNetworkOperator: String = telephonyManager.networkOperator
            println("Device NetworkOperator = $stringNetworkOperator")

            var stringPhoneOSVersion: String? = ""
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_PHONE_STATE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.

            } else {
                stringPhoneOSVersion = telephonyManager.deviceSoftwareVersion
            }
            println("Device PhoneOSVersion = $stringPhoneOSVersion")

            val stringVoiceMailNumber: String = telephonyManager.voiceMailNumber
            println("Device VoiceMailNumber = $stringVoiceMailNumber")

            val intPhoneType: Int = telephonyManager.phoneType
            var stringPhoneType: String? = ""
            when (intPhoneType) {
                TelephonyManager.PHONE_TYPE_NONE -> stringPhoneType = "No Type Found"
                TelephonyManager.PHONE_TYPE_SIP -> stringPhoneType = "SIP Type"
                TelephonyManager.PHONE_TYPE_CDMA -> stringPhoneType = "CDMA Type"
                TelephonyManager.PHONE_TYPE_GSM -> stringPhoneType = "GSM Type"
            }
            println("Device PhoneType = $stringPhoneType")

        } catch (e: Exception) {
            println(e)
        }
    }
}