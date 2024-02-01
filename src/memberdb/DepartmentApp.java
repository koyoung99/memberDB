package memberdb;

import java.util.Scanner;

public class DepartmentApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = new DepartmentDao();
		String num;
		boolean stop = true;
		while (true) {
			System.out.println("-------------------------------------------------------------");
			System.out.println("1.근태관리 2. 부서관리 3. 회원관리");
			System.out.print("메뉴선택 >");

			num = sc.nextLine();
			System.out.println();
//			departmentDao.memberStatus();

			switch (num) { // 근태관리 부서관리 회원관리 switch of num
			case "2":
				System.out.println("-------------------------------------------------------------");
				System.out.println("부서번호		부서이름		부서장		부서인원수");
				System.out.println("-------------------------------------------------------------");
				departmentDao.departmentMemberInfo();
				System.out.println("\n");
				System.out.println("\t\t\t<메뉴>");
				System.out.println("==========================================================");
				System.out.println(" 1.부서추가 2.부서수정 3.부서삭제");
				System.out.println("==========================================================");
				System.out.println("(뒤로가기: -1, 종료: /q)");
				System.out.print("메뉴선택 >");
				String i = sc.nextLine();
				System.out.println();
				switch (i) {
				case "1":
					// 1-1. 부서추가
					System.out.println("----------------------------------------------------");
					System.out.print("추가할 부서이름 입력>");
					String departmentName = sc.nextLine();
					DepartmentVo departmentVo1 = new DepartmentVo(departmentName);
					departmentDao.departmentInsert(departmentVo1);
					break;

				case "2":
					System.out.println("1.부서장 2.부서명 \n" + "\n(-1.뒤로가기 /q.종료)");
					System.out.println("-------------------------------------------");
					System.out.print("메뉴선택>");
					String menuNo = sc.nextLine();
					switch (menuNo) {
					case "1":
						// 2-1. 부서장수정
						departmentDao.departmentNameInfo();
						System.out.println();
						System.out.print("수정할 부서선택>");
						int no01 = sc.nextInt();
						sc.nextLine();
						departmentDao.departmentMemberInfo(no01);
						System.out.print("새로운 부서장선택>");
						int managerUpdate = sc.nextInt();
						departmentDao.newManagerUpdate(managerUpdate, no01);
						break;
					case "2":
						// 부서명 수정
						departmentDao.departmentNameInfo();
						System.out.println();

						System.out.print("수정할 부서선택>");
						int no02 = sc.nextInt();
						sc.nextLine();
						System.out.print("새로운 부서명선택>");
						String newdepartmentName = sc.nextLine();

						departmentDao.departmentUpdate(newdepartmentName, no02);

					case "-1":
						break;

					case "/q":
						System.out.println("시스템종료");
						sc.close();
						return;
					default:
						System.out.println("다시입력해주세요.");
						break;
					}// 부서장 부서명 switch of menuNo()
					break;
				case "3":

//					List<DepartmentVo> departmentNameList=departmentDao.departmentNameList();
					System.out.println("--------------부서삭제-------------------");
//					for(int no=1; no<departmentNameList.size(); no++) {
//						departmentNameList.get(no);
//					}
					System.out.println("삭제할 부서의 번호를 입력하세요.");
					// System.out.println("1.인사팀 2.관리팀 3.영업팀 4.개발팀");
					departmentDao.departmentNameInfo();
					System.out.println("(뒤로가기: -1, 종료: /q)");
					System.out.print("선택 >");
					num = sc.nextLine();
					if (num.equals("1")) {
						// departmentDao.departmentUpdate(num);
						System.out.println("");
						departmentDao.departmentDelete(num);
						System.out.println("인사팀이 삭제되었습니다.");
						// 바뀐 리스트 출력

					} else if (num.equals("2")) {
						// departmentDao.departmentUpdate(num);
						System.out.println("");
						departmentDao.departmentDelete(num);
						System.out.println("관리팀이 삭제되었습니다.");
						// 바뀐 리스트 출력
					} else if (num.equals("3")) {
						// departmentDao.departmentUpdate(num);
						System.out.println("");
						departmentDao.departmentDelete(num);
						System.out.println("영업팀이 삭제되었습니다.");
						// 바뀐 리스트 출력
					} else if (num.equals("4")) {
						// departmentDao.departmentUpdate(num);
						System.out.println("");
						departmentDao.departmentDelete(num);
						System.out.println("개발팀이 삭제되었습니다.");
						// 바뀐 리스트 출력
					}
					break;
				} // 부서추가 부서수정 부서삭제 switch of i()
				break;
			case "-1":
				break;
			case "/q":
//				stop = false;
				System.out.println("시스템종료");
				sc.close();
				return;

			default:
				System.out.println("다시 입력해주세요");
				break;
			}// switch of num()
		} // while()
	} // main()
} // class()
