package mage.abilities.keyword;

import mage.abilities.common.EntersBattlefieldTriggeredAbility;
import mage.abilities.effects.common.CreateTokenAttachSourceEffect;
import mage.game.permanent.token.GermToken;

public class LivingWeaponAbility extends EntersBattlefieldTriggeredAbility {

    public LivingWeaponAbility() {
        super(new CreateTokenAttachSourceEffect(new GermToken()));
    }

    public LivingWeaponAbility(final LivingWeaponAbility ability) {
        super(ability);
    }

    @Override
    public String getRule() {
        return "Living weapon <i>(When this Equipment enters the battlefield, " +
                "create a 0/0 black Phyrexian Germ creature token, then attach this to it.)</i>";
    }

    @Override
    public EntersBattlefieldTriggeredAbility copy() {
        return new LivingWeaponAbility(this);
    }
}
