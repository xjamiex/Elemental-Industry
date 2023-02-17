package elementalindustry;

import elementalindustry.content.EIBlocks;
import elementalindustry.content.EIItems;
import elementalindustry.content.EIUnitTypes;
import mindustry.mod.*;

public class ElementalIndustry extends Mod{

    public ElementalIndustry(){

    }

    @Override
    public void loadContent(){
        EIItems.load();
        EIBlocks.load();
        EIUnitTypes.load();
    }

}
