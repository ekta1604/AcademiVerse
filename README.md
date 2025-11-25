# AcademiVerse

**The Modern Learning Management System**

A comprehensive, cloud-native academic management platform built with Spring Boot and Next.js, designed to streamline educational processes and enhance collaboration between students and instructors. AcademiVerse brings together intuitive course management, intelligent assessment tools, and real-time collaboration features.

**Powered by AI** | **Cloud-Ready** | **Enterprise Secure**

## Features

### For Students
- **Interactive Courses**: Enroll in courses, access comprehensive materials, and track your learning progress in real-time
- **Assignment Tracking**: Submit assignments seamlessly with deadline management and instant feedback
- **Quiz & Assessment**: Take interactive quizzes with immediate grading and performance analytics
- **Personal Dashboard**: Organize your academic life with an integrated to-do list and task management system
- **Performance Analytics**: Monitor your grades across all courses with detailed performance insights
- **Peer Collaboration**: Connect with classmates and engage in course discussions

### For Instructors
- **Comprehensive Course Management**: Create and manage courses, organize modules, and structure content effortlessly
- **Smart Assignment Builder**: Design assignments with flexible file upload support and deadline configuration
- **AI-Powered Quiz Generation**: **NEW** Automatically generate quiz questions from course materials using OpenAI API
- **Intelligent Grading System**: Efficient grading workflows with bulk operations and detailed analytics
- **Class Communication**: Post announcements and maintain active communication with your entire class
- **Grade Management**: Track and manage student performance with detailed reporting and export capabilities

## Architecture

```
AcademiVerse/
├── academiverse-api/          # Spring Boot Backend
│   ├── src/main/java/
│   │   └── com/academiverse/
│   │       ├── controller/    # REST API endpoints
│   │       ├── service/       # Business logic
│   │       ├── model/         # JPA entities
│   │       ├── repository/    # Data access layer
│   │       ├── dto/           # Data transfer objects
│   │       └── util/          # Utility classes
│   └── src/main/resources/
│       └── application.properties
├── academiverse-ui/           # Next.js Frontend
│   ├── src/app/
│   │   ├── (routes)/          # Page routes
│   │   ├── components/        # Reusable UI components
│   │   ├── services/          # API service layer
│   │   └── lib/               # Utilities and configurations
│   └── cypress/               # E2E tests
└── .circleci/                 # CI/CD configuration
```

## Tech Stack

### Backend
- **Framework**: Spring Boot 3.x
- **Database**: MySQL/PostgreSQL (AWS RDS)
- **ORM**: Spring Data JPA
- **Authentication & Security**: Spring Security with OAuth2 (Azure Entra ID)
- **Cloud Storage**: AWS S3 for file management
- **AI Integration**: OpenAI API for intelligent quiz generation from document content
- **PDF Processing**: PDFBox for document parsing and text extraction
- **Testing**: JUnit & Spring Security Test

### Frontend
- **Framework**: Next.js 14 (React 18)
- **UI Components**: Material-UI (MUI) with custom CSS styling
- **State Management**: NextAuth.js with Azure Entra ID integration
- **HTTP Client**: Axios for API communication
- **Testing & QA**: Jest for unit testing, Cypress for end-to-end testing
- **Date Management**: Day.js for lightweight date handling

### DevOps & Deployment
- **CI/CD Pipeline**: CircleCI for automated testing and deployment
- **Cloud Hosting**: AWS Elastic Beanstalk for scalable backend deployment
- **Version Control**: Git with GitHub
- **Infrastructure**: AWS cloud services (RDS, S3, Elastic Beanstalk)

## Prerequisites

- **Java**: 17 or higher
- **Node.js**: 18 or higher
- **MySQL**: 8.0 or higher
- **Maven**: 3.6 or higher
- **Git**: Latest version

## Quick Start

### 1. Clone the Repository
```bash
git clone https://github.com/hetvijoshi/AcademiVerse.git
cd AcademiVerse
```

### 2. Backend Setup
```bash
cd academiverse-api

# Configure database in application.properties
# Update the following properties:
# spring.datasource.url=jdbc:mysql://localhost:3306/academiverse
# spring.datasource.username=your_username
# spring.datasource.password=your_password

# Install dependencies and run
./mvnw clean install
./mvnw spring-boot:run
```

The backend will be available at `http://localhost:8080`

### 3. Frontend Setup
```bash
cd academiverse-ui

# Install dependencies
npm install

# Configure environment variables
cp .env.example .env.local
# Update API_URL and other configuration in .env.local

# Run development server
npm run dev
```

The frontend will be available at `http://localhost:3000`

## Configuration

### OpenAI Integration Setup
To enable AI-powered quiz generation, you'll need to configure your OpenAI API key:

```properties
# Backend Configuration
# Add your OpenAI API key in QuizService.java
# Replace "Bearer " with "Bearer YOUR_OPENAI_API_KEY"
```

The system will automatically:
- Extract text from uploaded course documents (PDF support)
- Send content to OpenAI GPT-4 for intelligent question generation
- Parse and validate the generated questions
- Return formatted quiz questions ready for student assessment

### Backend Configuration
Create `application.properties` in `src/main/resources/`:

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/academiverse
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

# AWS S3 Configuration
aws.s3.bucket.name=your-bucket-name
aws.s3.region=your-region
aws.access.key=your-access-key
aws.secret.key=your-secret-key

# Server Configuration
server.port=8080
```

### Frontend Configuration
Create `.env.local` in the frontend directory:

```env
NEXTAUTH_URL=http://localhost:3000
NEXTAUTH_SECRET=your-secret-key
API_BASE_URL=http://localhost:8080
```

Configure the HTTP client in `src/lib/client/http.js` to use `API_BASE_URL` as the base URL for all API requests.

## Testing

### Backend Tests
```bash
cd academiverse-api
./mvnw test
```

### Frontend Tests
```bash
cd academiverse-ui
npm run test:e2e           # E2E tests with Cypress
```

## Deployment

### Backend Deployment (AWS Elastic Beanstalk)
```bash
cd academiverse-api
./mvnw clean package
eb init
eb create
eb deploy
```

## Database Schema

### Core Entities
- **User**: Students, instructors, and administrators
- **Course**: Academic courses
- **Module**: Course content modules
- **Assignment**: Course assignments
- **Quiz**: Interactive assessments
- **Grade**: Student performance records
- **Enrollment**: Course enrollment records

## Security

AcademiVerse implements enterprise-grade security measures:

- **Enterprise Authentication**: Azure Entra ID integration for secure single sign-on
- **JWT Token Security**: JSON Web Tokens with role-based access control (RBAC)
- **SQL Injection Prevention**: Parameterized queries and ORM protection via Spring Data JPA
- **Input Validation & Sanitization**: Comprehensive server-side validation and HTML sanitization
- **Secure File Handling**: AWS S3 integration for secure document storage
- **OAuth2 Security**: Industry-standard OAuth2 for API security

## Key Innovations

- **AI-Powered Content Analysis**: Automatically generate assessment questions from course documents using OpenAI's advanced language models
- **Responsive Design**: Fully responsive UI that works seamlessly across desktop, tablet, and mobile devices
- **Cloud-Native Architecture**: Built for scalability and reliability on AWS infrastructure
- **Real-time Updates**: Instant synchronization of grades, announcements, and course materials
- **Advanced Analytics**: Comprehensive dashboards for tracking student progress and course performance
- **Enterprise-Grade Security**: Multi-layered security with OAuth2 and role-based access control

## Acknowledgments

- Spring Boot community for excellent documentation
- Next.js team for the amazing framework
- All contributors who helped build this project

---

**Made with ❤️ by the AcademiVerse Team**
