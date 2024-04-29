package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int testCase = 1000000000; // 전체 시뮬레이션 횟수
        int switchWins = 0; // 문을 바꿨을 때의 이긴 횟수
        int stayWins = 0; // 처음 선택을 유지했을 때의 이긴 횟수

        Random random = new Random();

        for (int i = 0; i < testCase; i++) {
            // 세 개의 문 중 하나에 차를 랜덤하게 배치
            int carDoor = random.nextInt(3) + 1;

            // 참가자가 처음 문을 선택
            int initialChoice = random.nextInt(3) + 1;

            // 사회자가 열 문 선택 (차가 있는 문이 아니고 참가자가 선택한 문이 아니어야 함)
            int openDoor = -1;
            do {
                openDoor = random.nextInt(3) + 1;
            } while (openDoor == carDoor || openDoor == initialChoice);

            // 참가자가 바꾼 최종 선택 (참가자가 선택한 문이 아니고 열린 문이 아니어야 함)
            int finalChoice = -1;
            do {
                finalChoice = random.nextInt(3) + 1;
            } while (finalChoice == openDoor || finalChoice == initialChoice);

            // 바꾼 선택이 차가 있는 문인 경우
            if (finalChoice == carDoor) {
                switchWins++;
            }
            // 처음 선택을 유지했을 때 차가 있는 문인 경우
            if (initialChoice == carDoor) {
                stayWins++;
            }
        }

        // 결과 출력
        System.out.println("바꿨을 때 맞춘 횟수: " + switchWins);
        System.out.println("선택을 유지했을 때 맞춘 횟수: " + stayWins);
        System.out.println("바꿨을때의 승률: " + (double) switchWins / testCase * 100 + "%");
        System.out.println("선택을 유지했을 때의 승률: " + (double) stayWins / testCase * 100 + "%");
    }
}