package domain;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.*;
public class BlockSectionDA {
    private List<BlockSection> blockSectionList;

    public List<BlockSection> getBlockSectionList() {
        return blockSectionList;
    }

    public BlockSectionDA() throws FileNotFoundException {
        Scanner blockSectionInfo = new Scanner(
                new FileReader("src/domain/blockSection.csv"));

        blockSectionList = new ArrayList<>();

        while (blockSectionInfo.hasNext()) {
            BlockSection blockSection = new BlockSection();

            String rowBlockSection = blockSectionInfo.nextLine();

            String[] rowBlockSectionSpecific = new String[2];
            rowBlockSectionSpecific = rowBlockSection.split(",");


            blockSection.setBlockCode(rowBlockSectionSpecific[0].trim());
            blockSection.setDescription(rowBlockSectionSpecific[1].trim());
            blockSection.setAdviser(rowBlockSectionSpecific[2].trim());

            StudentDA studentDA = new StudentDA(blockSection.getBlockCode());
            blockSection.setStudentList(studentDA.getStudentList());

            blockSectionList.add(blockSection);
        }
        blockSectionInfo.close();

    }
}

