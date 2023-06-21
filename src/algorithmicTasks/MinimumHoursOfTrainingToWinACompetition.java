package algorithmicTasks;

//You are entering a competition, and are given two positive integers initialEnergy and initialExperience denoting your
// initial energy and initial experience respectively.
//
//        You are also given two 0-indexed integer arrays energy and experience, both of length n.
//
//        You will face n opponents in order. The energy and experience of the ith opponent is denoted by
//        energy[i] and experience[i] respectively. When you face an opponent, you need to have both strictly
//        greater experience and energy to defeat them and move to the next opponent if available.
//
//        Defeating the ith opponent increases your experience by experience[i], but decreases your energy by energy[i].
//
//        Before starting the competition, you can train for some number of hours. After each hour of training,
//        you can either choose to increase your initial experience by one, or increase your initial energy by one.
//
//        Return the minimum number of training hours required to defeat all n opponents.

import java.util.Arrays;

class MinimumHoursOfTrainingToWinACompetition {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int minNumberOfHours = 0;
        for (int i = 0; i < energy.length; i++) {
            while (initialEnergy <= energy[i]) {
                minNumberOfHours++;
                initialEnergy++;
            }
            while (initialExperience <= experience[i]) {
                minNumberOfHours++;
                initialExperience++;
            }
            initialEnergy -= energy[i];
            initialExperience += experience[i];
        }
        return minNumberOfHours;
    }
}
