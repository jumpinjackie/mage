package mage.cards.d;

import mage.abilities.Ability;
import mage.abilities.common.PutIntoGraveFromAnywhereSourceAbility;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.common.AttachEffect;
import mage.abilities.effects.common.ExileSourceEffect;
import mage.abilities.effects.common.continuous.BoostEnchantedEffect;
import mage.abilities.keyword.EnchantAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.constants.SubType;
import mage.target.TargetPermanent;
import mage.target.common.TargetCreaturePermanent;

import java.util.UUID;

/**
 * @author TheElk801
 */
public final class DrogskolArmaments extends CardImpl {

    public DrogskolArmaments(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.ENCHANTMENT}, "");

        this.subtype.add(SubType.AURA);
        this.color.setWhite(true);
        this.nightCard = true;

        // Enchant creature
        TargetPermanent auraTarget = new TargetCreaturePermanent();
        this.getSpellAbility().addTarget(auraTarget);
        this.getSpellAbility().addEffect(new AttachEffect(Outcome.BoostCreature));
        Ability ability = new EnchantAbility(auraTarget.getTargetName());
        this.addAbility(ability);

        // Enchanted creature gets +2/+2.
        this.addAbility(new SimpleStaticAbility(new BoostEnchantedEffect(2, 2)));

        // If Drogskol Armaments would be put into a graveyard from anywhere, exile it instead.
        this.addAbility(new PutIntoGraveFromAnywhereSourceAbility(new ExileSourceEffect().setText("exile it instead")));
    }

    private DrogskolArmaments(final DrogskolArmaments card) {
        super(card);
    }

    @Override
    public DrogskolArmaments copy() {
        return new DrogskolArmaments(this);
    }
}
