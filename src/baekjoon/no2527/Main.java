package baekjoon.no2527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static class Square {
		
		int[] leftTop;		// 왼쪽 위
		int[] rightBottom;	// 오른쪽 아래
		int[] rightTop;		// 오른쪽 위
		int[] leftBottom;	// 왼쪽 아래
		
		public Square(int[] leftTop, int[] rightBottom, int[] rightTop, int[] leftBottom) {
			this.leftTop = leftTop;
			this.rightBottom = rightBottom;
			this.rightTop = rightTop;
			this.leftBottom = leftBottom;
		}
		
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			Square[] squares = new Square[2];
			for (int j = 0; j < 2; j++) {
				int leftTopX = Integer.parseInt(tokenizer.nextToken());
				int leftTopY = Integer.parseInt(tokenizer.nextToken());
				int rightBottomX = Integer.parseInt(tokenizer.nextToken());
				int rightBottomY = Integer.parseInt(tokenizer.nextToken());

				squares[j] = new Square(
						new int[] { leftTopX, leftTopY },
						new int[] { rightBottomX, rightBottomY },
						new int[] { rightBottomX, leftTopY },
						new int[] { leftTopX, rightBottomY }
				);
			}

			sb.append(searchSquare(squares)).append("\n");
		}

		System.out.println(sb);
    }

    private static char searchSquare(Square[] squares) {
		// 점 판단
		if (squares[0].rightBottom[0] == squares[1].leftTop[0] && squares[0].rightBottom[1] == squares[1].leftTop[1])
			return 'c';

		if (squares[0].rightTop[0] == squares[1].leftBottom[0] && squares[0].rightTop[1] == squares[1].leftBottom[1])
			return 'c';

		// 공통부분이 없는 경우
		if (squares[0].rightBottom[0] < squares[1].leftTop[0])
			return 'd';

		if (squares[0].rightBottom[1] < squares[1].leftTop[1])
			return 'd';

		if (squares[1].rightBottom[0] < squares[0].leftTop[0])
			return 'd';

		if (squares[1].rightBottom[1] < squares[0].leftTop[1])
			return 'd';

		// 선분 판단
		if (squares[0].leftTop[1] == squares[1].leftBottom[1])
			return 'b';

		if (squares[0].rightBottom[0] == squares[1].leftTop[0])
			return 'b';

		if (squares[1].leftTop[1] == squares[0].leftBottom[1])
			return 'b';

		if (squares[1].rightBottom[0] == squares[0].leftTop[0])
			return 'b';

		return 'a';
	}

}
