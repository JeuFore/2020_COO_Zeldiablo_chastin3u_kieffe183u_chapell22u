package code.jeu;

import java.util.ArrayList;

public class BlocksList {

    private ArrayList<Block> list;

    public BlocksList() {
        this.list = new ArrayList<>();
        this.list.add(Block.trap);
        this.list.add(Block.fire);
    }

    public Block getBlock(int n) {
        Block b = null;
        for (Block block : list) {
            if (block.getId() == n)
                b = block;
        }
        return b;
    }
}
