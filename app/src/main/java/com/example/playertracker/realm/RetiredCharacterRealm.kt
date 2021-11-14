package com.example.playertracker.realm

import com.example.playertracker.CharacterClasses
import io.realm.RealmObject
import io.realm.RealmSet
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import org.bson.types.ObjectId

open class RetiredCharacterRealm(
    @PrimaryKey
    var id: String = ObjectId().toHexString(),
    @Required
    var name: String = "",
    var level: Int = 0,
    @Required
    var characterClass: String? = null,
    var selectedAbilities: RealmSet<AbilityCardRealm>? = RealmSet<AbilityCardRealm>()
    //Chosen perks

) : RealmObject() {
}