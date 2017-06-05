// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.

package hs;

public enum CardClass {
	
	NEUTRAL("Neutral"),
	
	DRUID("Druid"),
	HUNTER("Hunter"),
	MAGE("Mage"),
	PALADIN("Paladin"),
	PRIEST("Priest"),
	ROUGE("Rouge"),
	SHAMAN("Shaman"),
	WARLOCK("Warlock"),
	WARRIOR("Warrior");
	
	String name;
	
	CardClass(String name) {
		this.name = name;
	}
}
