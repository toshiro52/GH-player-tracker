package com.example.playertracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.realm.Realm
import io.realm.RealmConfiguration

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Realm.init(this)
        val configuration = RealmConfiguration.Builder()
            .allowQueriesOnUiThread(true)
            .allowWritesOnUiThread(true)
            .schemaVersion(0)
            .name("tempName")
            .build()


        val fragmentManager: FragmentManager = supportFragmentManager

        val frag1: Fragment = PlayerStatFragment()
        val frag2: Fragment = ItemListFragment()
        val frag3: Fragment = AttackDeckFragment()
        val frag4: Fragment = PerkFragment()
        val frag5: Fragment = ActionCardFragment()

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener { item ->
            lateinit var fragment: Fragment
            when(item.itemId) {
                R.id.playerStatFragment -> fragment = frag1
                R.id.itemListFragment -> fragment = frag2
                R.id.attackDeckFragment -> fragment = frag3
                R.id.perkFragment -> fragment = frag4
                R.id.actionCardFragment -> fragment = frag5
            }
            fragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment).commit()
            true
        }

        bottomNavigationView.selectedItemId = R.id.playerStatFragment

    }
}